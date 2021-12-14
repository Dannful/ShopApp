function deletePrompt(name, id) {
    var ok = confirm("Are you sure you wish to delete \"" + name + "\"?");
    if (ok) {
        document.getElementById("formDelete" + id).submit();
    }
}


