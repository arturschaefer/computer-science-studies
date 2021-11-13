### Interface Segregation Principle

`no client should be forced to depend on methods it does not use
`

The Interface Segregation Principle sounds pretty simply right? ISP violations can sneak into your system over time as features are added and requirements change. Codebases that violate this principle tend to be a bit tough to change as a lot of side effects can occur due to the larger interfaces and classes that implement them. What we’re aiming for is a few smaller interfaces, for specific tasks, rather than larger more generic ones.

- [Before fix](./error)
- [Fixed](./fixed)