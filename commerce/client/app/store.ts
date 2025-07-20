import { create } from "zustand";

interface CountStore {
  count: number;
  increase: (by: number) => void;
}

const useCountStore = create<CountStore>()((set) => ({
  count: 0,
  increase: (by) => set((state) => ({ count: state.count + by })),
}));

export { useCountStore };
