function Cricket() {

  const players = [
    { id: 1, name: "Virat Kohli", role: "Batsman" },
    { id: 2, name: "Rohit Sharma", role: "Captain" },
    { id: 3, name: "Jasprit Bumrah", role: "Bowler" },
    { id: 4, name: "Hardik Pandya", role: "All Rounder" }
  ];

  return (
    <div style={{ padding: "20px" }}>
      <h1>Indian Cricket Team</h1>

      <table border="1" cellPadding="10">
        <thead>
          <tr>
            <th>ID</th>
            <th>Player</th>
            <th>Role</th>
          </tr>
        </thead>

        <tbody>
          {players.map(({ id, name, role }) => (
            <tr key={id}>
              <td>{id}</td>
              <td>{name}</td>
              <td>{role}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}

export default Cricket;