const url = 'http://localhost:8081';

const getToken = () => {
    //pedir un token a una api
    ///api/v1/auth
    const data = {
        username : document.getElementById('username').value,
        password : document.getElementById('password').value
    }
    //algo nativo de los browser para  hacer peticiones asincrónicas
    fetch(`${url}/api/v1/auth/authenticate`,{
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify(data),
        })
        .then(response => response.text())
        .then(data => console.log(data));
}

const findUsers = () => {
    //pedir un token a una api
    ///api/v1/auth

    //algo nativo de los browser para  hacer peticiones asincrónicas
    fetch(`${url}/user`)
        .then(response => response.json())
        .then(data => console.log(data));
}

const btn = document.getElementById('btn-gettoken');
btn.addEventListener('click',getToken);