package be.techfix.advent.tasks;

public class SonarSweep {


    public int getNumberofIncreased(int... sweeps) {
        int increasedCount = 0;
        for (int i = 1; i < sweeps.length; i++) {
            if (sweeps[i] > sweeps[i - 1]) {
                increasedCount++;
            }
        }
        return increasedCount;
    }

    public int[] getSumOf3SizeWindow(int... sweeps) {
        int[] summingSweeps = new int[sweeps.length];
        int count = 0;
        for (int i = 0; i < sweeps.length; i++) {
            summingSweeps[count++] = getSweep(i + 1, sweeps) + getSweep(i + 2, sweeps) + sweeps[i];
        }
        return summingSweeps;
    }

    private int getSweep(int i, int[] sweeps) {
        if (i >= sweeps.length) return 0;
        return sweeps[i];
    }
}
