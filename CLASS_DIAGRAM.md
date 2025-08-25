# UML Class Diagram

```
┌─────────────────────────────────────┐
│              Item (Abstract)        │
├─────────────────────────────────────┤
│ - id: int                          │
│ - name: String                     │
│ - quantity: int                    │
│ - price: double                    │
│ - LOW_STOCK_THRESHOLD: int         │
├─────────────────────────────────────┤
│ + Item(id, name, qty, price)       │
│ + getId(): int                     │
│ + getName(): String                │
│ + getQuantity(): int               │
│ + getPrice(): double               │
│ + setQuantity(int): void           │
│ + setPrice(double): void           │
│ + isLowStock(): boolean            │
│ + toString(): String               │
│ + getCategory(): String (abstract) │
│ + calculateValue(): double (abs)   │
│ + needsSpecialHandling(): bool(abs)│
└─────────────────────────────────────┘
                    ▲
                    │
        ┌───────────┼───────────┐
        │           │           │
┌───────▼────┐ ┌────▼────┐ ┌────▼────┐
│Electronics │ │Clothing │ │  Food   │
├────────────┤ ├─────────┤ ├─────────┤
│-warranty:  │ │-size:   │ │-expiry: │
│ int        │ │ String  │ │LocalDate│
├────────────┤ ├─────────┤ ├─────────┤
│+Electronics│ │+Clothing│ │+Food()  │
│()          │ │()       │ │+isExpir-│
│+getWarranty│ │+getSize │ │ingSoon()│
│(): int     │ │():String│ │:boolean │
└────────────┘ └─────────┘ └─────────┘

┌─────────────────────────────────────┐
│         InventoryManager            │
├─────────────────────────────────────┤
│ - inventory: Map<Integer, Item>     │
│ - nextId: int                       │
├─────────────────────────────────────┤
│ + addElectronics(...): void         │
│ + addClothing(...): void            │
│ + addFood(...): void                │
│ + viewAllProducts(): void           │
│ + showLowStockAlerts(): void        │
│ + calculateTotalValue(): void       │
│ + updateQuantity(int, int): void    │
│ + deleteProduct(int): void          │
│ + searchProduct(int): void          │
└─────────────────────────────────────┘
                    ▲
                    │ uses
┌─────────────────────────────────────┐
│          InventorySystem            │
├─────────────────────────────────────┤
│ - manager: InventoryManager         │
│ - scanner: Scanner                  │
├─────────────────────────────────────┤
│ + main(String[]): void              │
│ - showMenu(): void                  │
│ - addProductMenu(): void            │
│ - updateQuantity(): void            │
│ - searchProduct(): void             │
└─────────────────────────────────────┘
```

## Relationships
- **Inheritance**: Electronics, Clothing, Food extend Item
- **Composition**: InventoryManager contains Map of Items
- **Dependency**: InventorySystem depends on InventoryManager