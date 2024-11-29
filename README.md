# Java-QuartzScheduler
### Quartz scheduler demo with Spring Boot

---

Quartz is an open-source, heavily featured job-scheduling framework written in Java and has been designed to integrate
with any kind of J2EE or J2SE framework. If an application is expected to perform tasks at scheduled intervals or due to
some events, Quartz is a great fit:

- **Trigger Email reminders or alerts:** such as password expiry mails or other kinds of reminder alerts
- **Perform File-transfer or Messaging operations:** jobs can be easily scheduled at certain intervals to publish/consume
  messages/data/files from various brokers or FTP sites
- **Auto-generate reports:** nightly/weekly reports to showcase business performance
- **Driving The Task Workflow:** e-Commerce organizations can schedule a job to fire exactly at certain intervals to pick an
  order from a channel and process it for fulfillment or manifestation

Documentation: http://www.quartz-scheduler.org/documentation/2.4.0-SNAPSHOT/index.html

---
### Quartz key components:

To improve scalability, Quartz runs on a multi-threaded environment. This helps the framework to run jobs concurrently.

![Quartz](src/main/resources/static/images/quartz.jpg?raw=true "Quartz Scheduler")

A **Scheduler**’s life-cycle is bounded by it’s creation, via a **SchedulerFactory** and a call to its shutdown() method. 
Once created the Scheduler interface can be used add, remove, and list Jobs and Triggers, and perform other 
scheduling-related operations (such as pausing a trigger). However, the Scheduler will not actually act on any triggers 
(execute jobs) until it has been started with the start() method.

**Scheduler Factory:**
- The factory bean that is responsible for building the Scheduler model and wiring in all the
  dependent components, based on the contents of the quartz properties file.

**Scheduler:**
- The main API for interacting with the scheduler.
- Maintains the JobDetail/Trigger registry. It is also responsible for executing the associated jobs when a trigger fires.

**Scheduler Thread:**
- The thread responsible for performing the work of firing the triggers. It contacts the JobStore to get the next set of
  triggers to be fired.

**JobBuilder:** 
- Define/build JobDetail instances, which define instances of Jobs.

**Job:**
- An interface that must be implemented by the task, that you wish to have executed by the scheduler.
- **@DisallowConcurrentExecution** is an annotation that can be added to the Job class that tells Quartz not to execute 
multiple instances of a given job definition (that refers to the given job class) concurrently. 
- **@PersistJobDataAfterExecution** is an annotation that can be added to the Job class that tells Quartz to update the 
stored copy of the JobDetail’s JobDataMap after the execute() method completes successfully (without throwing an 
exception), such that the next execution of the same job (JobDetail) receives the updated values rather than the 
originally stored values.
- If you use the @PersistJobDataAfterExecution annotation, you should strongly consider also using the 
@DisallowConcurrentExecution annotation, in order to avoid possible confusion (race conditions) of what data was left 
stored when two instances of the same job (JobDetail) executed concurrently.

**JobDetail:**
- Define instances of Jobs.

**TriggerBuilder:** 
- Define/build Trigger instances.

**Trigger:**
- Instructs the scheduler about the time that the associated job should be fired.

**JobStore:**
- An interface to be implemented by the classes that provide a storage mechanism for Jobs and Triggers.

**ThreadPool:**
- A job to be executed is transferred to the pool of threads, represented by the ThreadPool.

**Worker Threads:**
- Individual threads that build up the ThreadPool and execute jobs.

---
### Database connection:

Quartz brings in its own built-in JobStores. In Spring Boot, we can choose between:

**In-Memory JobStores:**
- Keep all the data in RAM, so that when the application stops or crashes, all data is dumped and all the scheduling information is lost. For this, we use a RAMJobStore.

**JDBC JobStores:**
- Persist all the data in datastore so that the data is not lost. Configuration is bit more involved than in-memory (RAM) job stores.

**TerracottaJobStore** 
- Provides a means for scaling and robustness without the use of a database. This means your database 
can be kept free of load from Quartz, and can instead have all of its resources saved for the rest of your application.

**Note:** You can choose these JobStore types regardless of your database.

---
### Job triggers:

There are two types of triggers in Quartz - CronTrigger and SimpleTrigger. These correspond to the CronScheduler and
SimpleScheduler respectively, and we can create the triggers using their respective factories.

**CronTrigger:**
- Triggers based on a cron expression

**SimpleTrigger:**
- Trigers on an interval.

---
### Listeners:

Listeners are objects that you create to perform actions based on events occurring within the scheduler. As you can 
probably guess, **TriggerListeners** receive events related to triggers, and **JobListeners** receive events related to jobs.

- Trigger-related events include: trigger firings, trigger mis-firings (discussed in the “Triggers” section of this 
document), and trigger completions (the jobs fired off by the trigger is finished).

- Job-related events include: a notification that the job is about to be executed, and a notification when the job has 
completed execution.

**SchedulerListeners** are much like TriggerListeners and JobListeners, except they receive notification of events within 
the Scheduler itself - not necessarily events related to a specific trigger or job.

- Scheduler-related events include: the addition of a job/trigger, the removal of a job/trigger, a serious error within 
the scheduler, notification of the scheduler being shutdown, and others.

---