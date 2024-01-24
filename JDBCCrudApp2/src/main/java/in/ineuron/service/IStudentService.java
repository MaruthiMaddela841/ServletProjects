package in.ineuron.service;

import in.ineuron.dto.Student;

public interface IStudentService {
	public String addStudent(Student student);
	public Student searchStudent(Integer id);
	public String updateStudent(Integer sid, String sname, Integer sage,String saddress);
	public String updateStudent(Student student);
	public String deleteStudent(Integer id);
	
}
