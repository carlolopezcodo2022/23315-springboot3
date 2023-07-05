/*
    Closure javascript
*/

function loginUC (repository) {

    async function exec(username,password) {
        const resp = await repository(username, password);
        const jwt = await resp.text();        
        return jwtAdapter(jwt);
    }

    return exec;
}
