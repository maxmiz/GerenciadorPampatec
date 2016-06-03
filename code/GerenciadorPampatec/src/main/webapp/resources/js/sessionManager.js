    /* 
     * To change this license header, choose License Headers in Project Properties.
     * To change this template file, choose Tools | Templates
     * and open the template in the editor.
     */

/**
 * 
 * @returns {undefined}
 */
function sessionCountdown() {
    var clock, countup;
    clock = $('.your-clock').FlipClock(10, {
        countdown: true,
        clockFace: 'MinuteCounter',
        language: 'pt-br'
    });

    countup = setInterval(function () {
        if (clock.getTime().time === -1) {
            showSweetAlert();
            clearInterval(countup);
        }
    }, 500);
}

/**
 * 
 * @returns {undefined}
 */
function showSweetAlert() {
//    setTimeout(function () {
        triggerParaInvalidarSessao();
        // sweetAlert: http://t4t5.github.io/sweetalert/
        sweetAlert({
            title: "Bah!",
            text: "Sua sessão expirou!",
            type: "error",
            confirmButtonColor: '#00A859'
        }, function () {
            // Redireciona o usuário para a página de login.
            window.location.href = "/GerenciadorPampatec/loginEmpreendedor.jsf";
        });
//    }, (tempoMaxSessao - 1) * 1000);

    /**
     * O metodo é chamado no sweetAlert somente para ativar um controle remoto 
     * esse controle remote aciona um metodo para invalidar a sessão quando o "bah!" é chamado.
     * @returns {undefined}
     */
    function triggerParaInvalidarSessao() {
    }
}