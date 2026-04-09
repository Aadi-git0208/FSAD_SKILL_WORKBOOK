import React from "react";
import axios from "axios";

function StudentList({ students, fetchStudents, setEditData }) {

  const deleteStudent = async (id) => {
    await axios.delete(`http://localhost:8080/students/${id}`);
    fetchStudents();
  };

  return (
    <div>
      <h2>Student List</h2>

      {students.map((s) => (
        <div key={s.id}>
          <p>{s.name} | {s.email} | {s.course}</p>
          <button onClick={() => setEditData(s)}>Edit</button>
          <button onClick={() => deleteStudent(s.id)}>Delete</button>
        </div>
      ))}
    </div>
  );
}

export default StudentList;