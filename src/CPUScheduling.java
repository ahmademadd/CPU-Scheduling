import java.util.*;

public class CPUScheduling {

    static class Process {
        int pid, arrivalTime, burstTime, completionTime, waitingTime, turnaroundTime, remainingTime;

        public Process(int pid, int arrivalTime, int burstTime) {
            this.pid = pid;
            this.arrivalTime = arrivalTime;
            this.burstTime = burstTime;
            this.remainingTime = burstTime;
        }
    }

    public static void fcfs(List<Process> processes) {
        processes.sort(Comparator.comparingInt(p -> p.arrivalTime));
        int currentTime = 0;

        for (Process p : processes) {
            if (currentTime < p.arrivalTime) {
                currentTime = p.arrivalTime;
            }
            p.completionTime = currentTime + p.burstTime;
            currentTime += p.burstTime;

            p.turnaroundTime = p.completionTime - p.arrivalTime;
            p.waitingTime = p.turnaroundTime - p.burstTime;
        }
    }

    public static void srtf(List<Process> processes) {
        int currentTime = 0, completed = 0, n = processes.size();
        Process currentProcess = null;

        while (completed < n) {
            for (Process p : processes) {
                if (p.arrivalTime <= currentTime && p.remainingTime > 0 &&
                        (currentProcess == null || p.remainingTime < currentProcess.remainingTime)) {
                    currentProcess = p;
                }
            }

            if (currentProcess != null) {
                currentProcess.remainingTime--;
                currentTime++;

                if (currentProcess.remainingTime == 0) {
                    currentProcess.completionTime = currentTime;
                    currentProcess.turnaroundTime = currentProcess.completionTime - currentProcess.arrivalTime;
                    currentProcess.waitingTime = currentProcess.turnaroundTime - currentProcess.burstTime;
                    completed++;
                    currentProcess = null;
                }
            } else {
                currentTime++;
            }
        }
    }

    public static void displayResults(List<Process> processes, String algorithm) {
        double totalTAT = 0, totalWT = 0;
        System.out.println("\nResults for " + algorithm + ":");
        System.out.println("PID Arrival Burst Completion Turnaround Waiting");
        for (Process p : processes) {
            totalTAT += p.turnaroundTime;
            totalWT += p.waitingTime;
            System.out.println(p.pid + "\t\t" + p.arrivalTime + "\t\t" + p.burstTime + "\t\t" + p.completionTime + "\t\t" +
                    p.turnaroundTime + "\t\t" + p.waitingTime);
        }
        System.out.println("Average Turnaround Time: " + (totalTAT / processes.size()));
        System.out.println("Average Waiting Time: " + (totalWT / processes.size()));
    }

    public static void main(String[] args) {
        List<Process> processes = new ArrayList<>();
        processes.add(new Process(1, 0, 7));
        processes.add(new Process(2, 2, 4));
        processes.add(new Process(3, 4, 1));
        processes.add(new Process(4, 5, 4));

        // FCFS
        List<Process> fcfsProcesses = new ArrayList<>();
        for (Process p : processes) {
            fcfsProcesses.add(new Process(p.pid, p.arrivalTime, p.burstTime));
        }
        fcfs(fcfsProcesses);
        displayResults(fcfsProcesses, "FCFS");

        // SRTF
        List<Process> srtfProcesses = new ArrayList<>();
        for (Process p : processes) {
            srtfProcesses.add(new Process(p.pid, p.arrivalTime, p.burstTime));
        }
        srtf(srtfProcesses);
        displayResults(srtfProcesses, "SRTF");
    }
}

