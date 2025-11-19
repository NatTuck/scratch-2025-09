
# Scaling a Web Application

Our example app:

- A local mirror of Wikipedia
- With a search feature

That gives us about:

- 60 million pages
- 25 GB

We'll use a VPS like the ones we're using for class:

- 2 processor cores
- 2 GB of RAM
- 50 GB of disk

First design:

- Put everything in one table in our SQL database
  - Columns like: Article Title, Page Contents, etc

User story:

- User types in query
- Hits "search" button

Initial implementation:

- SQL DB does sequential scan over Page Contents column

Let's assume our disk can do reads 1 GB/second

- Need to scan 25 GB of data
- So this takes 25 seconds per query

## Optimization plan 1: Add an Index

- Simplest plan: Index on words in pages
- Assume 100 unique words per page
  - That'd be 6 billion records.
  - If we're moderately clever and maybe use
    some compression we can make this fit.
- Now we can find records containing words fast
- But that may give us too many records, since just
  having words isn't quite a match
- So we need to do some post-processing

New performance:

- Disk read is down to like 10 ms.
- But now post processing might be expensive, call it
  100 ms of compute.

Now instead of taking 25 seconds / query, we can do
10 queries per second.

## How to scale up more?

- Use all of our cores.
- If we're using Elixir / Phoenix, this probably is happening already.
- With another platform, we might have to explicitly add threads or processes.
- Luckily for us, these requests are independent for our web framework. We don't
need to worry about shared state except in the database.

With our two cores, we can get to 20 reqs / second.

We can scale further with more cores. For example, 8 cores probably gives us 80
reqs / second.

Next bottleneck is going to be the database itself.

## Scaling an SQL database

- SQL RDBMSes like PostgreSQL, MariaDB, MSSQL, etc scale nicely on
a single multi-socket server.
- Heavy duty server, which will give us maybe 100x the performance of
a cheap VPS.

But what if we can't fit on one server?

Need to split DB across multiple servers.

- SQL databases hate it when you do that.

The point of a SQL database is ACID guarantees.

Transactions are:

- Atomic
- Consistent
- Indepentant
- Durable

Guaranteeing this on a multi-server cluster is hard,
maybe impossible.

Problem: The CAP theorem.

- Consistency - Once a transaction has committed, future reads see that
                change.
- Availability - You can do a write in finite, bounded time.
- Partition Tolerance - This still works if your network splits.

We can't just turn a SQL server into a cluster without extra work.

But with extra work we can:

- Have replicas that are allowed to have old data and use those
  to speed up reads.
- Similarly, add other read cache mechanisms.
- Have multiple writable replicas, but allow confirmation delays.
- Modify our application to change the problem.
  - e.g. Sharding of tables (last name a-m goes to server 1, n-z server 2)
- Use a non-SQL datastore, "NoSQL"

## Bonus to moving to multiple servers: Replication for Redundancy

- We can configure our multiple SQL or NoSQL servers to allow and
  recover from failures.
- Generally, to completely survive a failure we need multiple copies
  of data - basically the same problem as RAID for disks.
- Cloud providers like having 3 copies of things.
