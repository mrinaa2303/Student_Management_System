const baseUrl = "/students";

// ADD STUDENT
function addStudent() {

    const name = document.getElementById("name").value;
    const email = document.getElementById("email").value;

    const student = {
        name: name,
        email: email
    };

    fetch(baseUrl, {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(student)
    })
    .then(response => response.json())
    .then(data => {
        alert("Student Added Successfully");
        document.getElementById("name").value = "";
        document.getElementById("email").value = "";
    })
    .catch(error => console.error("Error:", error));
}


// GET ALL STUDENTS
function getStudents() {

    fetch(baseUrl)
    .then(response => response.json())
    .then(data => {

        const tableBody = document.querySelector("#studentTable tbody");
        tableBody.innerHTML = "";

        data.forEach(student => {
            const row = `
                <tr>
                    <td>${student.id}</td>
                    <td>${student.name}</td>
                    <td>${student.email}</td>
                </tr>
            `;
            tableBody.innerHTML += row;
        });
    })
    .catch(error => console.error("Error:", error));
}
