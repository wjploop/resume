$(function () {

    let href = window.location.href.toString();
    resume_id = href.substr(href.indexOf("=") + 1);


    loadResume();

    //上传头像

    $(".avatar").on("click", showUpload);

});
let resume_id;
let resume;

function showUpload() {
    window.location.href = "upload.html";
}
function loadResume() {
    $.ajax({
        url: "resume/detail",
        dataType: "json",
        type: "get",
        data: {'id': resume_id},
        success: function (result) {
            resume = result.data;
            showResume();
        },
        error: function () {
            alert("请求失败");
        },

    })
}

function showResume() {
    showExperience();
    showEducation();
    showSkill();
    showPreference();
    showUser();
    loadAndShowAvatar()
}
function loadAndShowAvatar() {
    $.ajax({
        url:"/avatar",
        dataType:"json",
        type:"get",
        data:{"id":resume.avatarId},
        success:function (result) {

            $(".avatar img").attr("src", "data:image/jpg;base64,"+result.data);
        },
        error:function () {
            $("#avatar").attr("alt", "加载图片失败");
        }
    })
}
function showUser() {
    let user=resume.user;
    $(".info .name").text(user.name);
    $(".info .motto").text(user.motto);
    $(".info .sex>span").text(user.sex);
    $(".info .age>span").text(user.age);
    $(".info .address>span").text(user.address);
    $(".info .phone>span").text(user.phone);
    $(".info .email>span").text(user.email);

}
function showPreference() {
    let preference=resume.preference;
    $(".preference .job_function:nth-child(2)").text(preference.jobFunction);
    $(".preference .job_type:nth-child(1)").text(preference.jobType);
    $(".preference .job_city:nth-child(2)").text(preference.jobCity);
    $(".preference .salary:nth-child(2)").text(preference.salary);
    $(".preference .duty_time:nth-child(2)").text(preference.dutyTime);
}

function showSkill() {
    let skills = resume.skills;
    let container_skill = $(".skill .content");
    container_skill.empty();
    $.each(skills, function (index, skill) {
        let li = skillTemplate;
        li = li.replace("[skill_name]", skill.name)
            .replace("[skill_level_number]", skill.levelNumber)
            .replace("[skill_level_name]", skill.levelName);
        container_skill.append(li);
    })
}

function showEducation() {
    let educations = resume.educations;
    let container_education = $(".education .content");
    container_education.empty();
    $.each(educations, function (index, education) {
        let li = educationTemplate;
        li = li.replace("[time_period]", education.timePeriod)
            .replace("[school_name]", education.schoolName)
            .replace("[major]", education.major)
            .replace("[description]", education.description.replace("\n", "<br>").replace("\n", "<br>").replace("\n", "<br>"));
        container_education.prepend(li);
    })
}

function showExperience() {
    let experiences = resume.experiences;
    let container_experience = $(".experience .content");
    container_experience.empty();
    $.each(experiences, function (index, experience) {
        let li = experienceTemplate;
        li = li.replace("[time_period]", experience.timePeriod)
            .replace("[organization]", experience.organization)
            .replace("[job_title]", experience.jobTitle)
            .replace("[description]", experience.description.replace("\n", "<br>").replace("\n", "<br>").replace("\n", "<br>").replace("\n", "<br>"));
        container_experience.prepend(li);
    })
}

let experienceTemplate =
    '<div class="exp-item">' +
    '<div class="header">' +
    '<span class="time-period">[time_period]</span>' +
    '<span class="organization">[organization]</span>' +
    '<span class="job_title">[job_title]</span>' +
    '</div>' +
    '<div class="description">' +
    '[description]' +
    '</div>' +
    '</div>';

let educationTemplate =
    '<div class="edu-item">\n' +
    '<div class="header">\n' +
    '<span class="time-period">[time_period]</span>\n' +
    '<span class="school_name">[school_name]</span>\n' +
    '<span class="major">[major]</span>\n' +
    '</div>\n' +
    '<div class="description">\n' +
    '[description]' +
    '</div>\n' +
    '</div>';

let skillTemplate =
    '      <div class="skill-item">\n' +
    '                    <div class="skill-name">[skill_name]</div>\n' +
    '                    <div class="skill-level ">\n' +
    '                        <progress class="skill-level-number" value="[skill_level_number]" max="100"></progress>\n' +
    '                        <span class="skill-level-name">[skill_level_name]</span>\n' +
    '                    </div>\n' +
    '                </div>'