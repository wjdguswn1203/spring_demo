document.addEventListener("DOMContentLoaded", () => {
    const username = sessionStorage.getItem("userName");
    // 로그인 상태일 때만 로그아웃 버튼 보이기
    if (username) {
    document.getElementById("logoutBtn").style.display = "inline-block";
    }

    // 로그아웃 버튼 클릭 시 처리
    const logoutBtn = document.getElementById("logoutBtn");
    if (logoutBtn) {
    logoutBtn.addEventListener("click", () => {
      // sessionStorage 비우기
      sessionStorage.removeItem("userName");
      sessionStorage.removeItem("token"); // 토큰 같은 거 저장했다면 같이 삭제

      alert("로그아웃 되었습니다.");
      window.location.href = "/"; // 메인으로 이동
    });
    }
});