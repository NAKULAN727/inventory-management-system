# OOP Concepts Demonstrated

## 1. Inheritance
- **Base Class**: `Item` (abstract) defines common properties and behaviors
- **Derived Classes**: `Electronics`, `Clothing`, `Food` inherit from Item
- **Benefits**: Code reuse, consistent interface, extensibility

```java
public abstract class Item { /* common properties */ }
public class Electronics extends Item { /* specialized behavior */ }
```

## 2. Polymorphism
- **Method Overriding**: Each subclass implements abstract methods differently
- **Runtime Behavior**: Same method call produces different results based on object type

```java
// Different implementations of calculateValue()
Electronics: quantity * price * 1.1  (10% markup)
Clothing: quantity * price           (standard)
Food: quantity * price * 0.5         (50% if expiring)
```

## 3. Encapsulation
- **Data Hiding**: Private/protected fields with public getters/setters
- **Controlled Access**: Methods validate and control data modification
- **Information Hiding**: Internal implementation details are hidden

```java
private Map<Integer, Item> inventory; // Hidden implementation
public void addElectronics(...) { /* controlled access */ }
```

## 4. Abstraction
- **Abstract Class**: Item defines contract without full implementation
- **Abstract Methods**: Force subclasses to provide specific implementations
- **Interface Consistency**: All items follow same abstract contract

```java
public abstract String getCategory();
public abstract double calculateValue();
public abstract boolean needsSpecialHandling();
```

## 5. Additional OOP Features

### Composition
- InventoryManager **has-a** Map of Items (not inheritance)
- Demonstrates object relationships beyond inheritance

### Method Overloading
- Multiple constructors with different parameters
- Flexible object creation patterns

### Static Members
- `LOW_STOCK_THRESHOLD` shared across all items
- Class-level constants and utilities