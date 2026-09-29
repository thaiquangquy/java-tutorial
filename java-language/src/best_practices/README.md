# Java Best Practices

Practical guidelines and idioms worth following when writing Java, distinct from the [design patterns](../design_patterns/README.md) catalog. Design patterns solve *structural* problems; these practices are about writing code that's correct, readable, and maintainable day to day.

Each row below is a practice or principle. Where a runnable example exists in this repo, it's linked in the last column.

### **Object Design**

| Practice | Why it matters | Example |
|----------|-----------------|---------|
| **Favor immutability** | Immutable objects are thread-safe by default, easier to reason about, and can't be left in an inconsistent state. Use `final` fields, no setters, defensive copies for mutable inputs. | [immutability](immutability/Demo.java) |
| **Favor composition over inheritance** | Deep inheritance hierarchies couple subclasses to implementation details of their parents and are brittle to change. Prefer injecting behavior via interfaces. | See [Strategy](../design_patterns/behavioral/strategy) / [Decorator](../design_patterns/structural/decorator) patterns |
| **Program to an interface, not an implementation** | Keeps call sites decoupled from concrete types, making it easy to swap implementations (e.g. in tests). | See [Bridge](../design_patterns/structural/bridge) pattern |
| **Minimize mutability & scope of fields** | Fields should be `private` and `final` unless there's a specific reason otherwise; smaller scope means fewer places state can be corrupted. | [immutability](immutability/Demo.java) |

### **Null & Optional Handling**

| Practice | Why it matters | Example |
|----------|-----------------|---------|
| **Avoid returning `null` for "no result"** | `null` forces every caller to remember a check; forgetting one causes a `NullPointerException` far from the root cause. | [optional_usage](optional_usage/Demo.java) |
| **Use `Optional<T>` for possibly-absent return values** | Makes absence explicit in the method signature and forces callers to handle it via the `Optional` API instead of an implicit null check. | [optional_usage](optional_usage/Demo.java) |
| **Never use `Optional` for fields or parameters** | `Optional` was designed as a return type, not a general-purpose "maybe" wrapper — using it elsewhere adds overhead and serialization headaches without benefit. | — |

### **Resource & Exception Handling**

| Practice | Why it matters | Example |
|----------|-----------------|---------|
| **Use try-with-resources for anything `Closeable`/`AutoCloseable`** | Guarantees resources (files, sockets, DB connections) are closed even when an exception is thrown, without verbose `finally` blocks. | [resource_management](resource_management/Demo.java) |
| **Throw specific, meaningful exceptions** | A precise exception type (or a well-named custom one) tells the caller exactly what went wrong; catching broad types like `Exception` hides bugs. | [exception_handling](exception_handling/Demo.java) |
| **Never swallow exceptions silently** | An empty `catch` block hides failures and makes production issues nearly impossible to diagnose. At minimum, log with context before rethrowing or handling. | [exception_handling](exception_handling/Demo.java) |
| **Only catch exceptions you can actually handle** | Catching and immediately rethrowing (or logging and continuing incorrectly) adds noise without adding value — let it propagate instead. | [exception_handling](exception_handling/Demo.java) |

### **Collections & Generics**

| Practice | Why it matters | Example |
|----------|-----------------|---------|
| **Return empty collections, not `null`** | Lets callers use `for`/streams directly without a null check; pair with `Collections.emptyList()` to avoid extra allocation. | See [Set examples](../Set) |
| **Expose the narrowest useful type** (`List`, not `ArrayList`) | Decouples callers from the concrete implementation, so it can change later without breaking anything. | See [Set examples](../Set) |
| **Use `var` for obvious local types, explicit types for public APIs** | `var` reduces noise for local, easily-inferred types; explicit types in signatures are part of the contract and should stay explicit. | See [stream examples](../stream) |

### **Text Processing**

| Practice | Why it matters | Example |
|----------|-----------------|---------|
| **Use `Matcher.appendReplacement`/`appendTail` for pattern-based substitution, not `String.replace` in a loop** | A hand-rolled loop over `String.replace`/`indexOf` re-scans the whole string on every iteration and gets fragile fast (overlapping matches, unknown tokens). `Matcher` walks the string once and builds the result incrementally. | [regex_replacement](regex_replacement/Demo.java) |
| **Wrap replacement values in `Matcher.quoteReplacement`** | The replacement string passed to `appendReplacement` treats `$` and `\` as special (group references / escapes). If a replacement value can contain those characters, skipping this quoting silently corrupts the output or throws. | [regex_replacement](regex_replacement/Demo.java) |
| **Compile `Pattern`s once as `static final`, not per call** | Pattern compilation is relatively expensive; reusing a precompiled `Pattern` (as opposed to `String.matches()`, which compiles on every call) avoids doing that work repeatedly on a hot path. | [regex_replacement](regex_replacement/TemplateRenderer.java) |

### **Concurrency**

| Practice | Why it matters | Example |
|----------|-----------------|---------|
| **Prefer higher-level concurrency utilities over raw `Thread`/`synchronized`** | `java.util.concurrent` (executors, `ConcurrentHashMap`, atomics) is easier to get right than hand-rolled locking. | See [multi_threading examples](../multi_threading) |
| **Keep synchronized blocks small and document invariants** | Large critical sections hurt throughput and are harder to verify for correctness. | See [multi_threading examples](../multi_threading) |
| **Prefer immutable/thread-confined state over shared mutable state** | The safest way to avoid race conditions is to not share mutable state between threads at all. | [immutability](immutability/Demo.java) |

### **Naming & Style**

| Practice | Why it matters | Example |
|----------|-----------------|---------|
| **Names should reveal intent** | `daysSinceLastLogin` beats `d`; a reader shouldn't need to open the implementation to know what a variable holds. | — |
| **Keep methods short and single-purpose** | A method that does one thing is easier to name, test, and reuse (Single Responsibility at the method level). | — |
| **Avoid deep nesting — prefer early returns / guard clauses** | Flattening control flow reduces cognitive load and cyclomatic complexity. | — |

### **SOLID Principles**

| Principle | Rule of thumb |
|-----------|----------------|
| **S** — Single Responsibility | A class should have one reason to change. |
| **O** — Open/Closed | Open for extension, closed for modification — extend via new code, not by editing existing working code. |
| **L** — Liskov Substitution | A subtype must be usable anywhere its base type is expected, without surprising behavior. |
| **I** — Interface Segregation | Prefer several small, focused interfaces over one large one clients are forced to depend on in full. |
| **D** — Dependency Inversion | Depend on abstractions (interfaces), not concrete implementations — see the [design patterns](../design_patterns/README.md) that enable this (Strategy, Bridge, Factory Method). |

Source of general principles: [Effective Java (Joshua Bloch)](https://www.oreilly.com/library/view/effective-java-3rd/9780134686097/) and [refactoring.guru](https://refactoring.guru/).
