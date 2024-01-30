# Handle Error Patterns - Event-Driven Architecture

### Pattern 1: Use spring batch to handle event

<div align="center">
    <br />
    <img src="diagram/pattern-01.jpg" alt="Pattern 01">
</div>

#### Pros

- The event handle logic is totally isolated between all consumer group.
- It's very easy to implement because the Spring Framework already support everything.
- It's easy to scale-out event handle note, because the database is separate statefulset set.

#### Cons

- Must use a separate database to store and control job status for Spring Batch framework
- It's convenience if the consumer component has already own database. Spring batch can use this DB instance too.

### Pattern 2: Use retry topic for each consumer group

### Pattern 3: Just ignore error in we can