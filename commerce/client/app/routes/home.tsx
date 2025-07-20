import type { Route } from "./+types/home";
import { Welcome } from "~/welcome/welcome";

export function meta({}: Route.MetaArgs) {
  return [
    { title: "JP-Study Commerce" },
    { name: "description", content: "Welcome to JP-Study Commerce!" },
  ];
}

export default function Home() {
  return <Welcome />;
}
