package gameEngine.utils;

public class Timer
{

    /**
     * Time that the system started at and ends at
     */
    private long startTime;
    private long stopTime;

    /**
     * current/last time
     */
    private long lastTime;

    /**
     * Amount of time that the timer is set to in milliseconds
     */
    private long mAmt;

    /**
     * determines if the timer is done counting
     */
    public boolean isDone = false;

    /**
     * is the timer running? or is it done
     */
    public boolean isRunning;

    /**
     * starts the timer
     *
     * @param sAmt amount of time (seconds)
     */
    public void start(int sAmt)
    {
        if (isRunning)
        {
            System.out.println("[System]: thread/WARN - Timer cannot be started since it is already running (Timer)");
            return;
        }

        mAmt = sAmt * 1000L;

        startTime = System.currentTimeMillis();
        stopTime = startTime + mAmt;
        lastTime = startTime;

        isDone = false;

        isRunning = true;

        System.out.println("[System]: thread/INFO - Timer started (Timer)");
    }

    /**
     * stops the timer
     *
     * can only be invoked if the timer is running,
     * otherwise it returns the request
     */
    public void stop()
    {
        if (!isRunning)
        {
            System.out.println("[System]: thread/WARN - Timer cannot be stopped since it is not running (Timer)");
            return;
        }

        isRunning = false;
    }

    /**
     * Automatically stops and resets the timer
     */
    public void reset(int sAmt)
    {
        stop();

        mAmt = sAmt * 1000L;
    }

    /**
     * ticks the timer
     *
     * This method must be called in the tick method
     * of whatever object this timer is in
     */
    public void tick()
    {
        if (!isRunning)
            return;

        if (lastTime < stopTime && lastTime >= 0)
        {
            lastTime += 17;
        }
        else
        {
            isDone = true;
            stop();
            System.out.println("[System]: thread/INFO - Timer is done! (Timer)");
        }
    }

    /**
     * @return the beginning time
     */
    public long getStartTime()
    {
        return startTime;
    }

    public long getLastTimeSeconds()
    {
        long lastTimeMilli = lastTime - stopTime;
        return -((int) lastTimeMilli / 1000);
    }

}
