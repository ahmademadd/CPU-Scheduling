# CPU Scheduling Algorithms: FCFS and SRTF

### **1. Overview**
This program compares two CPU scheduling algorithms:
- **First-Come First-Served (FCFS)**
- **Shortest-Remaining-Time-First (SRTF)**

The program calculates and compares **average turnaround time** and **average waiting time** for the two algorithms.

---

### **2. Prerequisites**
- Java Development Kit (JDK) installed (version 8 or later).
- A text editor or IDE (e.g., IntelliJ IDEA, Eclipse, or VS Code).

---

### **3. How to Compile and Run**

1. **Save the Code**:
   - Save the provided code in a file named `CPUScheduling.java`.

2. **Compile the Program**:
   - Open a terminal/command prompt.
   - Navigate to the directory containing the `CPUScheduling.java` file.
   - Run the command:
     ```bash
     javac CPUScheduling.java
     ```

3. **Run the Program**:
   - Execute the compiled program using:
     ```bash
     java CPUScheduling
     ```

4. **View the Results**:
   - The program will display the scheduling results for FCFS and SRTF, including:
     - Turnaround time and waiting time for each process.
     - Average turnaround time and waiting time for each algorithm.

---

### **4. Input Details**
The program uses predefined processes with:
- **Arrival Time**: The time a process arrives in the queue.
- **Burst Time**: The time required by the process for execution.

You can modify these values in the `main()` method.

Example:
```java
processes.add(new Process(1, 0, 7));
processes.add(new Process(2, 2, 4));
processes.add(new Process(3, 4, 1));
processes.add(new Process(4, 5, 4));
```

---

### **5. Output**
The program outputs:
1. A table displaying process details and calculated metrics:
   - Completion Time
   - Turnaround Time
   - Waiting Time
2. Average Turnaround Time and Waiting Time for both algorithms.

#### Example Output:
```
Results for FCFS:
PID    Arrival    Burst    Completion    Turnaround    Waiting
1      0          7        7             7             0
2      2          4        11            9             5
...
Average Turnaround Time: 10.5
Average Waiting Time: 4.5
```

---

