function App() {

  const offices = [
    {
      id: 1,
      name: "Cognizant Chennai",
      rent: 55000,
      address: "Siruseri, Chennai"
    },
    {
      id: 2,
      name: "Cognizant Hyderabad",
      rent: 75000,
      address: "HITEC City, Hyderabad"
    },
    {
      id: 3,
      name: "Cognizant Bangalore",
      rent: 68000,
      address: "Electronic City, Bangalore"
    }
  ];

  return (
    <div style={{ padding: "20px" }}>
      <h1>Office Space Rental</h1>

      <table border="1" cellPadding="10">
        <thead>
          <tr>
            <th>Office Name</th>
            <th>Rent</th>
            <th>Address</th>
          </tr>
        </thead>

        <tbody>
          {offices.map((office) => (
            <tr key={office.id}>
              <td>{office.name}</td>

              <td
                style={{
                  color: office.rent < 60000 ? "red" : "green",
                  fontWeight: "bold"
                }}
              >
                ₹{office.rent}
              </td>

              <td>{office.address}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}

export default App;