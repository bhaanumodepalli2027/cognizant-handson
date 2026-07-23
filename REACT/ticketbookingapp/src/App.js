import { useState } from "react";

function App() {
  const [isLoggedIn, setIsLoggedIn] = useState(false);

  return (
    <div style={{ textAlign: "center", marginTop: "50px" }}>
      <h1>Ticket Booking Application</h1>

      {isLoggedIn ? (
        <>
          <h2>Welcome, User!</h2>
          <p>Your tickets can now be booked.</p>

          <button onClick={() => setIsLoggedIn(false)}>
            Logout
          </button>
        </>
      ) : (
        <>
          <h2>Guest User</h2>
          <p>Please login to book your tickets.</p>

          <button onClick={() => setIsLoggedIn(true)}>
            Login
          </button>
        </>
      )}
    </div>
  );
}

export default App;