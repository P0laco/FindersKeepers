export interface Activity {
  id: string;
  type: string;
  date: string;
  time: string;
  location: string;
  requiredPlayers: number;
  currentPlayers: number;
}

export interface User {
  id: string;
  name: string;
  email: string;
}