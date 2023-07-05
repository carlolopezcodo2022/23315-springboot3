function jwtAdapter (dataExterno) { //texto!
    
    const jwt = {
        type: 'Bearer',
        jwt: dataExterno
    }

    return jwt;
}