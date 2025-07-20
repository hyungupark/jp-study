import { useCountStore } from "~/store";

const bys: number[] = [1, 2, 3, 4, 5];

export function Welcome() {
  const counts = useCountStore((state) => state.count);
  const increaseCounts = useCountStore((state) => state.increase);

  return (
    <div
      style={{
        width: "100%",
        display: "flex",
        flexDirection: "column",
        justifyContent: "center",
        alignItems: "center",
      }}
    >
      <div style={{ padding: "30px" }}>{counts}</div>
      {bys.map((by: number) => (
        <div style={{ padding: "10px" }}>
          <button
            style={{
              backgroundColor: "grey",
              padding: "0 10px",
              borderRadius: "10%",
            }}
            onClick={() => increaseCounts(by)}
          >
            {by} up
          </button>
        </div>
      ))}
    </div>
  );
}
