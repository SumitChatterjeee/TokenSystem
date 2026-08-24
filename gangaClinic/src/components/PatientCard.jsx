import "../cssFiles/patientCard.css";

export default function PatientCard({
  patient,
  onAccept,
  onReject,
}) {
  const current = patient || {
    name: "No Patient",
    token: "--",
  };

  return (
    <div className="patient-card-page">
      <div className="patient-card">

        <div className="patient-card-token">
          #{current.token}
        </div>

        <div className="patient-card-info">
          <span className="patient-card-label">
            Patient
          </span>

          <h2>{current.name}</h2>
        </div>

        <div className="patient-card-actions">

          <button
            className="patient-action-btn reject-btn"
            onClick={onReject}
            aria-label="Reject patient"
          >
            ✕
          </button>

          <button
            className="patient-action-btn accept-btn"
            onClick={onAccept}
            aria-label="Accept patient"
          >
            ✓
          </button>

        </div>

      </div>
    </div>
  );
}