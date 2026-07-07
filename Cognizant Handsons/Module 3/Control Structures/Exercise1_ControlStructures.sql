
-- Exercise 1: Control Structures

-- Sample Data
INSERT INTO Customers VALUES (1,'Bhanu',65,15000,'FALSE');
INSERT INTO Customers VALUES (2,'Rahul',45,8000,'FALSE');
INSERT INTO Customers VALUES (3,'Kiran',70,20000,'FALSE');

INSERT INTO Loans VALUES (101,1,10,SYSDATE+10);
INSERT INTO Loans VALUES (102,2,11,SYSDATE+50);
INSERT INTO Loans VALUES (103,3,9,SYSDATE+20);

COMMIT;

-- Scenario 1: Apply 1% discount
BEGIN
   FOR rec IN (
      SELECT c.CustomerID, c.Age, l.LoanID
      FROM Customers c
      JOIN Loans l ON c.CustomerID = l.CustomerID
   )
   LOOP
      IF rec.Age > 60 THEN
         UPDATE Loans
         SET InterestRate = InterestRate - 1
         WHERE LoanID = rec.LoanID;
      END IF;
   END LOOP;
   COMMIT;
END;
/

-- Scenario 2: VIP Promotion
BEGIN
   FOR rec IN (
      SELECT CustomerID, Balance
      FROM Customers
   )
   LOOP
      IF rec.Balance > 10000 THEN
         UPDATE Customers
         SET IsVIP = 'TRUE'
         WHERE CustomerID = rec.CustomerID;
      END IF;
   END LOOP;
   COMMIT;
END;
/

-- Scenario 3: Loan Due Reminder
BEGIN
   FOR rec IN (
      SELECT c.Name, l.LoanID, l.DueDate
      FROM Customers c
      JOIN Loans l ON c.CustomerID = l.CustomerID
      WHERE l.DueDate BETWEEN SYSDATE AND SYSDATE + 30
   )
   LOOP
      DBMS_OUTPUT.PUT_LINE(
         'Reminder: Loan ' || rec.LoanID ||
         ' for ' || rec.Name ||
         ' is due on ' || TO_CHAR(rec.DueDate,'DD-MON-YYYY')
      );
   END LOOP;
END;
/
