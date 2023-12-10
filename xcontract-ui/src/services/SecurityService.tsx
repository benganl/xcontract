import { jwtDecode } from "jwt-decode";

export interface AuthRequest {
  username: string;
  password: string;
}

export interface AuthResponse {
  token: string;
  code: number;
  message: string;
}

export const handleLogin = async (loginDetails: AuthRequest) => {
  const response = await fetch("http://localhost:8080/auth/login", {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(loginDetails),
  });

  if (!response.ok) {
    throw Error("Authentication error");
  }

  const data: AuthResponse = await response.json();
  console.log("Auth token from server: ", data.token);

  console.log("data.code: ", data.code);
  if (data.code == 200) {
    localStorage.setItem("token", data.token);
  }
};

export const isLoggedIn = (): boolean => {
  const token = localStorage.getItem("token");
  if (token === null || token === undefined || token.trim() === "") {
    return false;
  }

  try {
    const exp = jwtDecode(token)?.exp;
    return exp !== undefined && exp !== null && exp * 1000 < Date.now();
  } catch (error) {
    console.log(error);
    return false;
  }
};
