import React, { useState } from "react";
import useForm from "react-hook-form";

function RegisterForm() {
  const [name, setName] = useState("");
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const { register, handleSubmit, errors } = useForm();

  const onSubmit = data => {
  onSubmit(console.log(data));};

  return (
    <div className="card" onSubmit={handleSubmit(onSubmit)}>
      <div className="card-body">
        <h4 className="card-title">Sign up</h4>
        <div>
          <div className="form-group">
            <label>Name:</label>
            <input
              name="name"
              type="text"
              className="form-control"
              value={name}
              onChange={e => setName(e.target.value)}
              placeholder="Name"
              ref={register({ required: true, minLength: 25 })}
            />
          </div>
          /error message
          {errors.name && <p>name required</p>}

          <div className="form-group">
            <label>Email:</label>
            <input
              name="email"
              type="email"
              value={email}
              onChange={e => setEmail(e.target.value)}
              className="form-control"
              placeholder="Email"
              ref={register({ required: true })}
            />
          </div>
          /email validation for input and "@"
          {errors.email && errors.email.type === "@" && <p>email required</p>}

          <div className="form-group">
            <label>Password:</label>
            <input
              name="password"
              type="password"
              placeholder="Password"
              className="form-control"
              value={password}
              onChange={e => setPassword(e.target.value)}
              ref={register({ required: true, minLength: 10 })}
            />
          </div>
          {errors.password && <p>password required</p>}

          <div className="form-group">
            <button
              className="btn btn-success"
              onClick={e => onSubmit({ name, email, password })}
            >
              Create account
            </button>
          </div>
        </div>
      </div>
    </div>
  );
}

export default RegisterForm;
