export default function TokenCard({ token, name }) {
  return (
    <div className="token-card-page">
      <div className="tokenCard">

        <span className="tokenCard-name">
          {name}
        </span>

        <span className="tokenCard-label">
          Your Token
        </span>

        <div className="tokenCard-number">
          {token}
        </div>

      </div>
    </div>
  );
}