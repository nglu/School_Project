package evc;

public class Switch
{
		private String name;
		private int idNumber;
		private String department;
		private String position;
		
		public Switch(String n, int id, String dep, String po)
		{
			name = n;
			idNumber = id;
			department = dep;
			position = po;
		}
		
		public Switch(String n, int id)
		{
			name = n;
			idNumber = id;
		}
		
		public Switch()
		{
			name = "";
			idNumber = 0;
			department = "";
			position = "";
		}
		
		public void setName(String n)
		{
			name = n;
		}
		
		public void setIDNumber(int id)
		{
			idNumber = id;
		}
		
		public void setDepartment(String dep)
		{
			department = dep;
		}
		
		public void setPosition(String po)
		{
			position = po;
		}
		
		public String getName()
		{
			return name;
		}
		
		public int getIDNumber()
		{
			return idNumber;
		}
		
		public String getDepartment()
		{
			return department;
		}
		
		public String getPosition()
		{
			return position;
		}
}