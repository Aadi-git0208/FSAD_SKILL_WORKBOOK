import React, { useState } from "react";
import axios from "axios";

function createStudentForm(editData) {
  return {
    name: editData?.name ?? "",
    email: editData?.email ?? "",
    course: editData?.course ?? ""
  };
}

function AddStudent({ fetchStudents, editData, setEditData }) {
  const [student, setStudent] = useState(() => createStudentForm(editData));

  const handleChange = (e) => {
    setStudent({ ...student, [e.target.name]: e.target.value });
  };

  const handleSubmit = async () => {
    if (editData) {
      await axios.put(`http://localhost:8080/students/${editData.id}`, student);
      setEditData(null);
    } else {
      await axios.post("http://localhost:8080/students", student);
    }
    setStudent({ name: "", email: "", course: "" });
    fetchStudents();
  };

  return (
    <div>
      <h2>{editData ? "Update Student" : "Add Student"}</h2>
      <input name="name" value={student.name} onChange={handleChange} placeholder="Name" />
      <input name="email" value={student.email} onChange={handleChange} placeholder="Email" />
      <input name="course" value={student.course} onChange={handleChange} placeholder="Course" />
      <button onClick={handleSubmit}>Submit</button>
    </div>
  );
}

export default AddStudent;