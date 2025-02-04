**Distributed Job Scheduler**
=============================

**Overview**
------------

The **Distributed Job Scheduler** is a scalable system designed to manage and execute jobs across multiple worker nodes in a distributed environment. It allows job submission, tracking, and execution while supporting high availability and fault tolerance. Admin functionalities are restricted to system administrators for managing worker nodes.

**Architecture**
----------------

### **Key Components**

1.  **Job**: Represents a unit of work to be scheduled and executed.
    
2.  **Task**: The actual work to be performed for a given job. Implements the Callable interface to allow asynchronous execution and return results.
    
3.  **WorkerNode**: Represents a node in the distributed system that executes jobs using an ExecutorService.
    

### **High-Level Flow**

1.  Users submit jobs to the scheduler.
    
2.  The scheduler assigns jobs to available worker nodes.
    
3.  Each worker node executes tasks asynchronously and updates the job status.
    
4.  System admins can manage the worker nodes (add/remove) to ensure scalability and reliability.