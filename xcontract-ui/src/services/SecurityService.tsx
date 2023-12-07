import { useContext } from "react";
import { ApplicationContext } from "../App";

export interface AuthRequest {
  username: string;
  password: string;
}

export interface AuthResponse {
  username: string;
  password: string;
}

const SecurityService = () => {
  const { state, setState } = useContext(ApplicationContext);
};

export default SecurityService;
