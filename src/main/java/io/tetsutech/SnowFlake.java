package io.tetsutech;

public class SnowFlake {

  /**
   * Starting timestamp (the adjacent time before the current time can be set)
   */
  private final static long START_STAMP = 1480166465631L;

  /**
   * Number of digits occupied by serial number
   */
  private final static long SEQUENCE_BIT = 12;
  /**
   * Number of digits occupied by machine identification
   */
  private final static long MACHINE_BIT = 5;
  /**
   * Number of bits occupied by data center
   */
  private final static long DATA_CENTER_BIT = 5;

  /**
   * Maximum value of each part
   */
  private final static long MAX_DATA_CENTER_NUM = ~(-1L << DATA_CENTER_BIT);
  private final static long MAX_MACHINE_NUM = ~(-1L << MACHINE_BIT);
  private final static long MAX_SEQUENCE = ~(-1L << SEQUENCE_BIT);

  /**
   * Displacement of each part to the left
   */
  private final static long MACHINE_LEFT = SEQUENCE_BIT;
  private final static long DATA_CENTER_LEFT = SEQUENCE_BIT + MACHINE_BIT;
  private final static long TIMESTAMP_LEFT = DATA_CENTER_LEFT + DATA_CENTER_BIT;

  /**
   * Data center ID(0~31)
   */
  private final long dataCenterId;
  /**
   * Working machine ID(0~31)
   */
  private final long machineId;
  /**
   * Sequence in milliseconds (0 ~ 4095)
   */
  private long sequence = 0L;
  /**
   * Last generated ID
   */
  private long lastStamp = -1L;

  public SnowFlake(long dataCenterId, long machineId) {
    if (dataCenterId > MAX_DATA_CENTER_NUM || dataCenterId < 0) {
      throw new IllegalArgumentException("dataCenterId can't be greater than MAX_DATA_CENTER_NUM or less than " +
          "0");
    }
    if (machineId > MAX_MACHINE_NUM || machineId < 0) {
      throw new IllegalArgumentException("machineId can't be greater than MAX_MACHINE_NUM or less than 0");
    }
    this.dataCenterId = dataCenterId;
    this.machineId = machineId;
  }

  /**
   * Generate next ID
   */
  public synchronized long nextId() {
    long currStamp = getNewStamp();
    if (currStamp < lastStamp) {
      throw new RuntimeException("Clock moved backwards.  Refusing to generate id");
    }

    if (currStamp == lastStamp) {
      // Within the same milliseconds, the serial number increases automatically
      sequence = (sequence + 1) & MAX_SEQUENCE;
      // The number of sequences in the same millisecond has reached the maximum
      if (sequence == 0L) {
        // Block to the next millisecond and get a new timestamp
        currStamp = getNextMill();
      }
    } else {
      // Within different milliseconds, the serial number is set to 0
      sequence = 0L;
    }

    lastStamp = currStamp;

    // Shift and put together by or operation to form a 64 bit ID
    return (currStamp - START_STAMP) << TIMESTAMP_LEFT // Timestamp part
        | dataCenterId << DATA_CENTER_LEFT // Data center part
        | machineId << MACHINE_LEFT // Machine identification part
        | sequence; // Serial number part
  }

  private long getNextMill() {
    long mill = getNewStamp();
    while (mill <= lastStamp) {
      mill = getNewStamp();
    }
    return mill;
  }

  private long getNewStamp() {
    return System.currentTimeMillis();
  }

  public static void main(String[] args) {
    SnowFlake snowFlake = new SnowFlake(11, 11);

    long start = System.currentTimeMillis();
    for (int i = 0; i < 10; i++) {
      System.out.println(snowFlake.nextId());
    }

    System.out.println(System.currentTimeMillis() - start);
  }
}
