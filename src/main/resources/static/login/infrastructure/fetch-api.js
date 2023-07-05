
function loginRepository() {
    
    async function login(username,password) {

        //NO TIENE QUE SABER QUE EXISTE UN HTML
        //algo nativo de los browser para  hacer peticiones asincrónicas
        const data = {
            username: username,
            password: password
        };

        //esrto es una Promise
        return await fetch(`${url}/api/v1/auth/authenticate`,{
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify(data),
        });/*
        .then(response => response.text())
        .then(data => console.log(data));*/
    }

    return login;
}