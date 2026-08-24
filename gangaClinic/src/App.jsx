import TokenForm from "./pages/TokenForm";
import TokenCard from "./pages/TokenCard";
import Login from "./pages/Login";
import Signup from "./pages/Signup";
import "./App.css";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import PatientCard from "./components/PatientCard";

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<TokenForm />} />
        <Route path="/login" element={<Login />} />
        <Route path="/signup" element={<Signup />} />
        <Route path="/token" element={<TokenCard token={12} name={"Sumit Chatterjee"} />} />
        <Route
          path="/doctor"
          element={
            <PatientCard
              patients={[
                { token: 12, name: "Sumit Chatterjee" },
                { token: 13, name: "Priya Sharma" },
                { token: 14, name: "Rahul Verma" },
                { token: 15, name: "Ananya Gupta" },
              ]}
            />
          }
        />
      </Routes>
    </BrowserRouter>
  );
}

export default App;