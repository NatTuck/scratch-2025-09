# Game Design

**Design Ideas**

User interface: 

 - Separate screen per room rather than continuous text log.
   - Maybe AI generated illustrations in addition to text later.
 - Direct keybindings by default.
   - We can even have different layouts per room.

**Design**

Data:

(database)

- Do you log in as a character, or as a user with mutltiple characters?
- Do we want to keep the room / zone structure?
  - How does moving between servers work?
- How are characters, mobs, items modelled?

(state)

- What data needs to survive a server reboot? That goes in the DB.
- What data can be transient? There are ways to handle that other
  than the DB.
- What data gets sent to the client? What data is stored on the client?



