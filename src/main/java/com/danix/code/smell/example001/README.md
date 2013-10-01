# Code smells

- Duplicated Code
  - For determining the fullName of the Customer
  - In the customer.withdraw method we can see similar code
  - Possible refactoring: Extract method

- Long Method
  - Customer.withdraw method has more than 5 lines of code
  - Possible refactorings: Extract method

- Divergent Change
  - Customer class has more than one reason to change. This is a violation of the SRP (Single Responsibility Principle)
  - Possible refactorings: Extract class

- Comments
  - The comments in the customer.withdraw method
  - Possible refactorings: make code speak for itself

- Switch Statements
  - Customer.withdraw method has a some switches
  - Does not respect OCP (Open Closed Principle)
  - Every time we want to add a new customer type we have to modify the two switches
  - Possible Refactorings: Replace conditional with polymorphism

- Feature Envy
  - Customer class has a fascination over the methods of the Account class
  - see the Customer.printCustomerAccount
  - also Customer.withdraw
  - high coupled with the Account class
  - Possible refactorings: Move method

- Inappropriate Intimacy
  - Customer.printCustomerDaysOverdrawn only uses methods from the Account class
  - Account.printCustomer only uses methods from the Customer class
  - it's a bidirectional feature envy
  - Possible refactorings: Move methods

- Primitive Obsession
  - Use a primitive type instead of a small object
  - Account.money should be in it's own class
  - Possible refactorings: Extract class, Introduce Parameter object

- Data Clumps
  - This is about groups of objects that are always grouped together
  - Account.money and Account.currency should have a class
  - Possible refactorings: Extract class, Introduce Parameter object

- Lazy Class
  - A class that's not doing enough
  - AccountType
  - Possible refactorings: Inline class