
# Semester Review

## Software Engineering

- Making software
- Managing the development process
- Working with a team
  - More than two people, for more than two weeks
- Workflow / Process
  - Agile development
- Defense against people breaking your stuff
  - Source control
  - Automated testing
  - Code reviews
  - Automated checks (e.g. credo)

## Agile Project Management

- Don't spend too much time on up-front planning.
- Get a minimal runnable program working as fast as
  possible, then iterate.
- Get the running program in front of the customer
  for feedback quickly and often.
  - Getting feedback from the actual customer is essential.
  - More than a week or two spent without customer feedback
    is likely to be wasted - lots of work on the wrong stuff.
- Focus on people and conversation over process and tools.

**In Practice, the consultants have taken over**

- Scrum
- Simplest version: A Kanban Board
  - The visual layout really is more useful than just
    having something like an issue tracker.
  - This really helps for a project manager

## Github Workflow

- Feature branch, for one "story"
- Pull request
- Someone else reviews and merges
  - Checklist
  - Manually check that it's focused on one topic
  - Don't pull it if it doesn't pass automated checks

## Basic Web Development

- Web
  - Browsers
  - Client / server communication via HTTP
  - JS code runs in browser
  - Can run anything on the server
- Development
- Using Elixir / Phoenix
  - LiveView
  - Ecto / PostgreSQL
  - OTP concepts: Supervisor, GenServer

## Game (Application) Design

- Data design
- States

## Generating Code with Aider

- Seems to help.
- We don't know what's going to happen with this stuff,
  but it probably won't go away.

## Random Topics

- Copyright and Licensing
  - Open source (esp. permissive) is safe because you don't need to do
    anything usually.
- Distributed state
  - Where do we have state in our application?
  - How do we make sure it's right, especially when it changes?
- Scaling and Replication

## Our App: Shard

- A Game
- Multiple concurrent users
- Good reasons to distinguish immediate and long-term state
- Good progress on: Gameplay, Initial zones, mechanics

Lots of trouble with:

- Account creation
  - Everyone always says email is the worst thing,
    we now have supporting evidence
- We haven't gotten to federation
  - Slightly disappointing
