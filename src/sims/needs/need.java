package sims.needs;

public class need {
    private double value;
    private double decayRate;
    private double threshold;

    //default
    public need()
    {
        this.value = 80;
        this.decayRate = 0.5;
        this.threshold = 30;
    }

    public need(double rate)
    {
        value = 80;
        decayRate = rate;
        threshold = 30;
    }

    //specific value
    public need(int value, int decayRate, double threshold)
    {
        this.value = value;
        this.decayRate = decayRate;
        this.threshold = threshold;
    }

    public double getValue() {
        return value;
    }

    public double getDecayRate() {
        return decayRate;
    }

    public void setValue(Double modify) {
        if (modify + this.value >= 100)
        {
            this.value = 100;
        }
        else if(modify+this.value <= 0)
        {
            this.value = 0;
        }
        else
        {
            this.value += modify;
        }
    }


    public boolean performDecay()
    {
        setValue(-(decayRate));
        return value < threshold;
    }
}
