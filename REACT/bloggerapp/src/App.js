import BookDetails from "./Components/BookDetails";
import BlogDetails from "./Components/BlogDetails";
import CourseDetails from "./Components/CourseDetails";

function App() {

  const showBooks = true;
  const showBlogs = true;
  const showCourses = true;

  return (
    <div style={{ padding: "20px" }}>
      <h1>Blogger Application</h1>

      {showBooks && <BookDetails />}

      {showBlogs ? <BlogDetails /> : <h3>No Blogs Available</h3>}

      {showCourses ? <CourseDetails /> : null}
    </div>
  );
}

export default App;