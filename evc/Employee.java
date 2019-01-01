package evc;

public class Employee
{
   private String name;             // Employee name
   private String employeeNumber;   // Employee number
   private String hireDate;         // Employee hire date
      
   public Employee(String n, String num, String date)
   {
      name = n;
      setEmployeeNumber(num);
      hireDate = date;
   }
      
   public Employee()
   {
      name = "";
      employeeNumber = "";
      hireDate = "";
   }

   public void setName(String n)
   {
      name = n;
   }

   public void setEmployeeNumber(String e)
   {
      if (isValidEmpNum(e))
         employeeNumber = e;
      else
         employeeNumber = "";
   }

   public void setHireDate(String h)
   {
      hireDate = h;
   }

   public String getName()
   {
      return name;
   }

   public String getEmployeeNumber()
   {
      return employeeNumber;
   }

   public String getHireDate()
   {
      return hireDate;
   }

   private boolean isValidEmpNum(String e)
   {
      boolean status = true;
      
      if (e.length() != 5)
         status = false;
      else
      {
         if ((!Character.isDigit(e.charAt(0))) ||
             (!Character.isDigit(e.charAt(1))) ||
             (!Character.isDigit(e.charAt(2))) ||
             (e.charAt(3) != '-')              ||
             (!Character.isLetter(e.charAt(4))))
               status = false;
      }
      
      return status;
   }
   
   public String toString()
   {
      String str = "Name: " + name + "\nEmployee Number: ";
      
      if (employeeNumber == "")
         str += "INVALID EMPLOYEE NUMBER";
      else
         str += employeeNumber;
         
      str += ("\nHire Date: " + hireDate);
      return str;
   }
}

