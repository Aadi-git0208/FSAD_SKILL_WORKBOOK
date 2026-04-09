import React, { useState, useEffect } from "react";
import axios from "axios";
import AddStudent from "./components/AddStudent";
import StudentList from "./components/StudentList";

function App() {
  const [students, setStudents] = useState([]);
  const [editData, setEditData] = useState(null);

  useEffect(() => {
    const fetchStudents = async () => {
      const res = await axios.get("http://localhost:8080/students");
      setStudents(res.data);
    };

    void fetchStudents();
  }, []);

  const fetchStudents = async () => {
    const res = await axios.get("http://localhost:8080/students");
    setStudents(res.data);
  };

  return (
    <div>
      <AddStudent
        key={editData?.id ?? "new"}
        fetchStudents={fetchStudents}
        editData={editData}
        setEditData={setEditData}
      />
      <StudentList
        students={students}
        fetchStudents={fetchStudents}
        setEditData={setEditData}
      />
    </div>
  );
}

export default App;