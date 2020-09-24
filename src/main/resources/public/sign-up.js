const signUp = (e) => {
    e.preventDefault();
    const formData = new FormData(e.target);
    const user = {};
    user['username'] = formData.get('username');
    user['password'] = formData.get('password');

    fetch(`/users/sign-up`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(user)
    });
};

document.addEventListener('DOMContentLoaded', function(){
    const signUpForm = document.querySelector('#signUpForm');
    signUpForm.addEventListener('submit', signUp);
});