const login = (e) => {
    e.preventDefault();
    const formData = new FormData(e.target);
    const user = {};
    user['username'] = formData.get('username');
    user['password'] = formData.get('password');

    fetch(`/login`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(user)
    });
};

document.addEventListener('DOMContentLoaded', function(){
    const loginForm = document.querySelector('#loginForm');
    loginForm.addEventListener('submit', login);
});