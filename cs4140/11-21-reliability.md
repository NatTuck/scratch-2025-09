
# Reliability

## Crashes

- Avoid writing bugs that cause the program to crash.
  - Programming language can help
  - Static analysis can help
- Crash recovery
  - This is one of the things that Erlang is built around.
  - Genservers / Supervisors / etc.
  - Other platforms have similar tools, although Erlang is
    really focused on this.
- What if a crash corrupts essential persistent state, like
  your whole database?
  - This is called a "backup restoration test". Don't fail it.

## Backups

What do we need to back up?

Goal: To be able to restore what we need to get up and running again.

- A full copy of the database, as recent a possible.
- Any other persistent state (e.g. uploaded files).
- Application source and assets to redeploy: Those are in git.
- It'd be nice to have a copy of pinned dependencies somewhere,
  in case our language repositories go down.
- Application secrets

How to backup a server?

- Database dump (e.g. pg_dump)
- Copy that secrets file.
- Store them somewhere off the server.
  - Small scale: A local PC
  - Larger scale: Some sort of cloud storage

How many backups:

- Some pattern: E.g. every day at midnight, keep the last 7.
- It's worth keeping older backups if they're cheap.

This is a good time to think about backups for your personal
PC. Do you have them?

You don't really have backups unless you've tested restoring them.

## Replicas

(Note: Replicas don't replace backups.)

What do we do if a mouse pees on our server motherboard?

We need to have another server that is running our application.

- For web / applications servers this is easy, especially if they're
  stateless or have no persistent state.
- Mostly we can just add more servers and run extra copies of the
  application.
- If load balancer, might need sticky sessions.

Hard part: Database server

- One master server handles all the writes.
- Replica servers get copies of all the writes and are ready to
  do fail-over if the master disappears.
- Replicas can do read only queries, for a bit of a performance boost.
- Multi-master replication exists, but usually is a mess.

Any sort of DB replication works best if the servers are next
to each other connected with high speed network links.

But what if your datacenter gits hit by a meteor?

- Need a complete set of servers that are still online.
- Answer: Multi-site replication
- Good way to cheat: Have your multiple sites be largely independent,
  with cross-site backups.

There are tools that can help with some of this:

- Some NoSQL datastores do multi-level replication.
- CockroachDB is a distributed SQL database.

## Monitoring

When your server goes down, you should get a text message.

You can buy a service:

- uptimerobot.com is popular

Or you can build something:

- Just a script that pings the server from another server.
  - You can send an email with SMTP, and you can whitelist your
    own server so it doesn't get spamboxed.
  - You can use a service that does SMTP or SMS or whatever.
- A script that does an HTTP request.
- You could get more complex with something like Selenium.
  - Pop up a browser.
  - Have the browser log in.
  - Have it effectively run an integration test.
