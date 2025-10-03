
## Testing

Kinds of tests:

- Logic unit test
  - Can just test pure functions
- Context unit tests
  - These require a test database to test against.
  - First, DB needs to be in known state, then any changes
    then test expected state
- Controller tests / liveview tests
  - These test individual user actions
- Integration tests
  - Testing entire sequences of actions

That's before we get to:

- JS Tests
- Full browser tests, that pop up a graphical
  browser and simulate real mouse clicks and stuff.




