
## Stuff to Do

- Persist Player Location
- Make the core combat mechanics work:
  - Attacking, being attacked
    - What's the difference between weapons?
    - Do skills / spells matter at all for minimal combat?
  - Status effects:
    - Bleeding, poison.
    - Generic concepts of DoT / HoT?
  - Damage types:
    - Slash / blunt / pointy / fire / etc
    - Type-specific defences (e.g. armor, resistances)
  - Combat effects engine
    - When do things happen?
    - How is our data structured?
    - When / why is data updated?
    - Does each player / monster have an Erlang process which
      stores a list of upcoming events, applies those events,
      and properly handles things like cooldowns / periodic
      events?
  - Killing monsters
  - Dying
  - Respawning?
- Pull together the inventory concepts
  - Make sure pick up object puts it in DB
  - Make sure drop object puts it in world
  - Combine weapons / items in a coherent way
- Build minimum viable dungeon.
  - Quest chain with mutiple goals that drags you
    through a zone and back to somewhere.
  - This should give loot, experience, etc.
- Figure out clases and levels.
  - How do you get XP?
  - Why do you want XP?
- Figure out how to allow for different zones on different servers.
  - What about the word gets checked into Git repo?
    - Tempting to put everything in Git that isn't live character data.
  - Are the non-git components portable between deployed servers?
  - What lives only in DB?
  - Backups?
- Zone Management
  - Improve the manual editor
  - Build procedural generation functionality
    - Standard maze generation algorithms are fun.
    - Abusing LLMs to enhance that might be even more fun.
