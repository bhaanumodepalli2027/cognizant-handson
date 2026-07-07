
-- ===========================================
-- Exercise 3 : Stored Procedures
-- ===========================================

-- Create Tables

CREATE TABLE Accounts (
   AccountID NUMBER PRIMARY KEY,
   AccountType VARCHAR2(20),
   Balance NUMBER
);

CREATE TABLE Employees (
   EmployeeID NUMBER PRIMARY KEY,
   EmployeeName VARCHAR2(50),
   Department VARCHAR2(30),
   Salary NUMBER
);

-- Sample Data

INSERT INTO Accounts VALUES (101,'Savings',50000);
INSERT INTO Accounts VALUES (102,'Savings',30000);
INSERT INTO Accounts VALUES (103,'Current',70000);

INSERT INTO Employees VALUES (1,'Bhanu','IT',50000);
INSERT INTO Employees VALUES (2,'Rahul','HR',40000);
INSERT INTO Employees VALUES (3,'Kiran','IT',60000);

COMMIT;

-- ===========================================
-- Scenario 1 : Process Monthly Interest
-- ===========================================

CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest
AS
BEGIN

   UPDATE Accounts
   SET Balance = Balance + (Balance * 0.01)
   WHERE AccountType = 'Savings';

   COMMIT;

END;
/

EXEC ProcessMonthlyInterest;

SELECT * FROM Accounts;

-- ===========================================
-- Scenario 2 : Update Employee Bonus
-- ===========================================

CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus
(
   p_department IN VARCHAR2,
   p_bonus      IN NUMBER
)
AS
BEGIN

   UPDATE Employees
   SET Salary = Salary + (Salary * p_bonus / 100)
   WHERE Department = p_department;

   COMMIT;

END;
/

EXEC UpdateEmployeeBonus('IT',10);

SELECT * FROM Employees;

-- ===========================================
-- Scenario 3 : Transfer Funds
-- ===========================================

CREATE OR REPLACE PROCEDURE TransferFunds
(
   p_from_account IN NUMBER,
   p_to_account   IN NUMBER,
   p_amount       IN NUMBER
)
AS

   v_balance NUMBER;

BEGIN

   SELECT Balance
   INTO v_balance
   FROM Accounts
   WHERE AccountID = p_from_account;

   IF v_balance >= p_amount THEN

      UPDATE Accounts
      SET Balance = Balance - p_amount
      WHERE AccountID = p_from_account;

      UPDATE Accounts
      SET Balance = Balance + p_amount
      WHERE AccountID = p_to_account;

      COMMIT;

      DBMS_OUTPUT.PUT_LINE('Transfer Successful');

   ELSE

      DBMS_OUTPUT.PUT_LINE('Insufficient Balance');

   END IF;

END;
/

EXEC TransferFunds(101,102,5000);

SELECT * FROM Accounts;

-- ===========================================
-- End of Exercise 3
-- ===========================================
